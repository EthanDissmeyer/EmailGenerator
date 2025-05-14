import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { EmailGeneratorComponent } from './email-generator.component';

describe('EmailGeneratorComponent', () => {
  let component: EmailGeneratorComponent;
  let fixture: ComponentFixture<EmailGeneratorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EmailGeneratorComponent],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(EmailGeneratorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
