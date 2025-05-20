import { TestBed } from '@angular/core/testing';
import { SelectTemplateService } from './select-template.service';
import { provideHttpClientTesting } from '@angular/common/http/testing';

describe('SelectTemplateService', () => {
  let service: SelectTemplateService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        SelectTemplateService,
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(SelectTemplateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
