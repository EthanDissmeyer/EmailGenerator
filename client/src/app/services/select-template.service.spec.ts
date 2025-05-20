import { TestBed } from '@angular/core/testing';
import { SelectTemplateService } from './select-template.service';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

describe('SelectTemplateService', () => {
  let service: SelectTemplateService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        SelectTemplateService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(SelectTemplateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
